import "./UkraineApp.css"
//import useFoods from "../useFoods";
//import UseFoodsReturnType from "../useFoods";
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import medImg from "../pics/med.png"
import clothImg from "../pics/cloth.png"
import corImg from "../pics/cor.png"
import foodImg from "../pics/food.png"
import flatImg from "../pics/flat.jpeg"
import carImg from "../pics/car.jpeg"

export default function Navbar() {

    return (
        <div className="box">
            
            <br></br>
            <a href="/food"className="logo-link"><img className="logo-img"src={medImg} alt="Medication"/></a>
            <a href="/food"className="logo-link"><img className="logo-img"src={clothImg} alt="Clothing"/></a>
            <a href="/food"className="logo-link"><img className="logo-img"src={corImg} alt="Corridors"/></a>
            <a href="/food"className="logo-link"><img className="logo-img"src={foodImg} alt="Food"/></a>
            <a href="/food"className="logo-link"><img className="logo-img"src={flatImg} alt="Flat"/></a>
            <a href="/food"className="logo-link"><img className="logo-img"src={carImg} alt="Cars"/></a>
            </div>

    )
}
