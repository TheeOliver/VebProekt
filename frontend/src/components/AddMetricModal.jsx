import { useState } from 'react';

export default function AddMetricModal({ onClose, onAdd }) {
    const [name, setName] = useState('');
    const [type, setType] = useState('YES_NO');
    const [comments, setComments] = useState(['', '']);

    const handleTypeChange = (val) => {
        setType(val);
        setComments(val === 'YES_NO' ? ['', ''] : ['', '', '', '', '']);
    };

    const handleCommentChange = (i, value) => {
        const newComments = [...comments];
        newComments[i] = value;
        setComments(newComments);
    };

    const handleSubmit = () => {
        const newMetric = {
            id: Date.now(),
            name,
            type,
            comments,
        };
        onAdd(newMetric);
        onClose();
    };

    return (
        <div style={{ border: '2px solid black', padding: 20, backgroundColor: '#eee' }}>
            <h3>Add Metric</h3>
            <input placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
            <select value={type} onChange={e => handleTypeChange(e.target.value)}>
                <option value="YES_NO">YES_NO</option>
                <option value="ONE_TO_FIVE">ONE_TO_FIVE</option>
            </select>

            {comments.map((comment, idx) => (
                <input
                    key={idx}
                    placeholder={`Comment ${idx}`}
                    value={comment}
                    onChange={e => handleCommentChange(idx, e.target.value)}
                />
            ))}

            <button onClick={handleSubmit}>Add</button>
            <button onClick={onClose}>Cancel</button>
        </div>
    );
}
