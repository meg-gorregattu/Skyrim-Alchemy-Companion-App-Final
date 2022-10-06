//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const ingredientsContainer = document.getElementById("ingredients-container")

const headers = {
    'Content-Type': 'application/json'
}


//Base URL

const baseUrl1 = "http://localhost:8080/api/v1/ingredients/"

//Handle Logout

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}


//Get All Ingredients

/*
async function getAllIngredients() {
    await fetch(baseUrl, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createIngredientCards(data))
        .catch(err => console.error(err))
}
*/



async function getAllIngredients() {
     await fetch(`${baseUrl1}`, {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    })
        .then(response => response.json())
        .then(response => createIngredientCards(response))
        //.catch(err => console.error(err))
}

//Create Ingredient Cards

const createIngredientCards = (array) => {
    ingredientsContainer.innerHTML = ''
    array.forEach(obj => {
        let ingredientCard = document.createElement("div")
        ingredientCard.classList.add("ingredient-card")
        ingredientCard.innerHTML = `
                    <p class="card-text">${obj.name}</p>

        `
        ingredientsContainer.append(ingredientCard);
    })
}


//Get All Ingredients

getAllIngredients();

