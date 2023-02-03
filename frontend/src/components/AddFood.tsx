import {NewFood} from "../model/Food";
import FoodGallery from "./FoodGallery";
import useFoods from "../useFoods";
import UseFoodsReturnType from "../useFoods";
import {ChangeEvent, useState} from "react";
import "./AddFood.css"

type AddFoodProps = {
    addFood: (newFood: NewFood) => Promise<any>
}

export default function AddFood(props: AddFoodProps) {

    const [name, setName] = useState<string>("")
    const useFoodComponent = useFoods();


    function onNameChange(event: ChangeEvent<HTMLInputElement>) {
        setName(event.target.value)
    }

    function onSaveClickRefresh() {
        onSaveClick();
        window.location.reload();
    }

    function onSaveClick() {
        props.addFood({name: name})
            .then(() => {
                setName("")
            })        
    }

    return (
        <div>
            <input className={"add-food__name"} placeholder={"Name"} value={name} onChange={onNameChange}/>
            <button className={"add-food__button"} onClick={onSaveClick}>Save</button>
            <FoodGallery showedComponents={useFoodComponent[0]} removeFood={useFoodComponent[2]}/>
        
        </div>
    )

}
