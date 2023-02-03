import {useEffect, useState} from "react";
import {NewFood, Food} from "../model/Food";
import axios from "axios";
import FoodGallery from './FoodGallery';
import AddFood from "./AddFood";
import "./UkraineApp.css"
import useFoods from "../useFoods";
import UseFoodsReturnType from "../useFoods";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Navbar from "./Navbar";
import Home from "./Home";
import FoodComponent from "./Food";

export default function UkraineApp() {


    const useFoodsComponent = useFoods();

    return (
        <div className={"ukraine-app"}>
            <h2> Thank you for supporting Democracy</h2>
            <h1 className={".h1"}>Ukraine Help App </h1>
            
            <BrowserRouter>
            <Routes>
                <Route path="/" element={<Navbar />} />
                <Route path="/add" element={<AddFood addFood={useFoodsComponent[1]}/>} />
                <Route path="/about" element={"About"} />
                <Route path={"/food"} element={<FoodComponent/>}> </Route>
                <Route path={"/food-gallery"} element={<FoodGallery showedComponents={[]} removeFood={function (id: string): void {
                        throw new Error("Function not implemented.");
                    } }/>}> </Route>
            </Routes>
            </BrowserRouter>
     
            <h1></h1>
            {/* <h1> Browser ends. useless Button: </h1>

            <button>Just a useless button</button>
            <h1 className={"Food-app__title"}>Title and bottom addFood:</h1>
            <AddFood addFood={useFoodsComponent[1]}/>
            <h1> FoodGallery: </h1>
            <FoodGallery showedComponents={useFoodsComponent[0]} removeFood={useFoodsComponent[2]}/> */}
        </div>
    )
}
