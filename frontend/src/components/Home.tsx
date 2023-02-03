import background from "../pics/food.png"
import {Link} from "react-router-dom";

export default function Home(){
    return(
        <div>
            <p>Description</p>
            <p>You can create new homes in our home app and the new created home will be add
                to one of four home houses after selecting process </p>
            <img src={background}/>
            <Link to={"/food"}>
                <button> Create your own food</button>
            </Link>

        </div>
    )
}