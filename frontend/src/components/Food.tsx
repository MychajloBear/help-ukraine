import AddFood from "./AddFood";
import "./UkraineApp.css"
import useFoods from "../useFoods";


export default function FoodComponent() {

    const useFoodComponent = useFoods();

    return (
        <div>
            <h1 className={"Food-app__title"}>Suggest your help:</h1>
            <AddFood addFood={useFoodComponent[1]}/>
            {}
        </div>
    )
}
