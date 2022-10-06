//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];


//DOM Elements
const submitForm = document.getElementById("recipe-form")
const recipeContainer = document.getElementById("recipe-container")

//Modal Elements
let nameEdit = document.getElementById("recipe-name")
let typeEdit = document.getElementById("recipe-type")
let ingredient1Edit = document.getElementById("recipe-ingredient1")
let ingredient2Edit = document.getElementById("recipe-ingredient2")
let ingredient3Edit = document.getElementById("recipe-ingredient3")
let effectsEdit = document.getElementById("recipe-effects")
let valueEdit = document.getElementById("recipe-value")

let updateRecipeBtn = document.getElementById("update-recipe-button")


const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/recipes/"


//Handle Logout

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}


//Handle Submit & Adding Recipe

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        name: document.getElementById("recipe-name-input").value,
        type: document.getElementById("recipe-type-input").value,
        ingredient_1: document.getElementById("recipe-ingredient1-input").value,
        ingredient_2: document.getElementById("recipe-ingredient2-input").value,
        ingredient_3: document.getElementById("recipe-ingredient3-input").value,
        effects: document.getElementById("recipe-effects-input").value,
        recipe_value: document.getElementById("recipe-value-input").value
    }
    await addRecipe(bodyObj);
    document.getElementById("recipe-name-input").value = '',
    document.getElementById("recipe-type-input").value = '',
    document.getElementById("recipe-ingredient1-input").value = '',
    document.getElementById("recipe-ingredient2-input").value = '',
    document.getElementById("recipe-ingredient3-input").value = '',
    document.getElementById("recipe-effects-input").value = '',
    document.getElementById("recipe-value-input").value = ''
}

async function addRecipe(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getRecipes(userId);
    }
}


//Getting Recipes

async function getRecipes(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createRecipeCards(data))
        .catch(err => console.error(err))
}

//Get Recipe by Id

async function getRecipeById(recipeId){
    await fetch(baseUrl + recipeId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}

async function handleRecipeEdit(recipeId){
    let bodyObj = {
        id: recipeId,
        name: nameEdit.value,
        type: typeEdit.value,
        ingredient_1: ingredient1Edit.value,
        ingredient_2: ingredient2Edit.value,
        ingredient_3: ingredient3Edit.value,
        effects: effectsEdit.value,
        recipe_value: valueEdit.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getRecipes(userId);
}

//Handle Delete

async function handleDelete(recipeId){
    await fetch(baseUrl + recipeId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getRecipes(userId);
}


//Creating Recipe Cards

const createRecipeCards = (array) => {
    recipeContainer.innerHTML = ''
    array.forEach(obj => {
        let recipeCard = document.createElement("div")
        recipeCard.classList.add("m-5")
        recipeCard.innerHTML = `
            <div class="card flex-wrap" style="width: 18rem; height: 30rem; background: rgb(255,255,255, .8);">
                <div class="card-body justify-content-between">
                    <p class="card-text">${obj.name}</p>
                    <hr>
                    <p class="card-text">-${obj.type}-</p>
                    <p class="card-text">${obj.ingredient_1}</p>
                    <p class="card-text">${obj.ingredient_2}</p>
                    <p class="card-text">${obj.ingredient_3}</p>
                    <p class="card-text">Effects: ${obj.effects}</p>
                    <p class="card-text">Value: ${obj.recipe_value}</p>

                        <button class="delete" onclick="handleDelete(${obj.id})">Delete</button>
                        <button onclick="getRecipeById(${obj.id})" type="button" class="edit" data-bs-toggle="modal" data-bs-target="#recipe-edit-modal">Edit</button>

                </div>
            </div>
        `
        recipeContainer.append(recipeCard);
    })
}


//Populate Modal

const populateModal = (obj) =>{
    nameEdit.innerText = ''
    typeEdit.innerText = ''
    ingredient1Edit.innerText = ''
    ingredient2Edit.innerText = ''
    ingredient3Edit.innerText = ''
    effectsEdit.innerText = ''
    valueEdit.innerText = ''

    nameEdit.innerText = obj.name
    typeEdit.innerText = obj.type
    ingredient1Edit.innerText = obj.ingredient_1
    ingredient2Edit.innerText = obj.ingredient_2
    ingredient3Edit.innerText = obj.ingredient_3
    effectsEdit.innerText = obj.effects
    valueEdit.innerText = obj.recipe_value


    updateRecipeBtn.setAttribute('data-recipe-id', obj.id)
}


getRecipes(userId);

submitForm.addEventListener("submit", handleSubmit)

updateRecipeBtn.addEventListener("click", (e)=>{
    let recipeId = e.target.getAttribute('data-recipe-id')
    handleRecipeEdit(recipeId);
})




