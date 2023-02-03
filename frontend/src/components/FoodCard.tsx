import {Food} from "../model/Food";
import "./FoodCard.css"

type FoodCardProps = {
    food: Food
    removeFood: (id: string) => void
}

export default function FoodCard(props: FoodCardProps) {

    function onDeleteClick() {
        props.removeFood(props.food.id)
    }

    return (
        <div className={"food-card"}>
            <p className="food-card__name">{props.food.name}</p>
            <p className="food-card__id">{props.food.id}</p>
            <button className={"food-card__button"} onClick={onDeleteClick}>Delete</button>
        </div>
    )
}
