import 'bootstrap/dist/css/bootstrap.min.css';

export default function WorkspaceButton({ id, name }) {
    return (

        <button className={"btn m-2 d-flex p-2"} style={{background: "rgb(244,244,244)", height:"70px"}}>
            <div className={"mx-2 col-2 align-content-center rounded-1 justify-content-between"}
                 style={{width: "50px", height: "50px", background: "#58A7BF", color: "white"}}>
                W{id}
            </div>
            <div className={"mx-2 col-5 d-flex align-items-center"}>
                {name}
            </div>
            <div className={"mx-2 col-5 d-flex align-items-center justify-content-end"}>
                Open →
            </div>
        </button>
    )
}
