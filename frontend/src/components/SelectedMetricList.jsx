import React from 'react';
import { DragDropContext, Droppable, Draggable } from 'react-beautiful-dnd';

export default function SelectedMetricList({ selectedMetrics, setSelectedMetrics }) {
    const handleDragEnd = (result) => {
        if (!result.destination) return;

        const reordered = Array.from(selectedMetrics);
        const [movedItem] = reordered.splice(result.source.index, 1);
        reordered.splice(result.destination.index, 0, movedItem);

        setSelectedMetrics(reordered);
    };

    return (
        <DragDropContext onDragEnd={handleDragEnd}>
            {/* IMPORTANT: Wrap in a div to ensure Droppable gets rendered */}
            <div style={{ minWidth: '200px', border: '1px solid black', padding: '10px' }}>
                <Droppable droppableId="metrics">
                    {(provided) => (
                        <div
                            ref={provided.innerRef}
                            {...provided.droppableProps}
                            style={{ minHeight: '50px' }}
                        >
                            {selectedMetrics.map((metric, index) => (
                                <Draggable
                                    key={metric.id.toString()}
                                    draggableId={metric.id.toString()}
                                    index={index}
                                >
                                    {(provided) => (
                                        <div
                                            ref={provided.innerRef}
                                            {...provided.draggableProps}
                                            {...provided.dragHandleProps}
                                            style={{
                                                ...provided.draggableProps.style,
                                                border: '1px solid #333',
                                                padding: '8px',
                                                marginBottom: '6px',
                                                backgroundColor: 'white',
                                            }}
                                        >
                                            {metric.name}
                                        </div>
                                    )}
                                </Draggable>
                            ))}
                            {provided.placeholder}
                        </div>
                    )}
                </Droppable>
            </div>
        </DragDropContext>
    );
}
