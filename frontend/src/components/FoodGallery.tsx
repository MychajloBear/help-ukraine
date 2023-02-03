import {Food} from "../model/Food";
import FoodCard from "./FoodCard";
import "./FoodGallery.css"

type FoodGalleryProps = {
    showedComponents: Food[]
    removeFood: (id: string) => void
}

export default function FoodGallery(props: FoodGalleryProps) {
   return (
       <div className="Food-gallery">
           {props.showedComponents.map(Food => 
           <FoodCard food={Food} key={Food.id} removeFood=
           {props.removeFood}/>)}
       </div>
   )
}
