let completed=false;
function AddList(){
    let task=document.getElementById("taskinput").value;
   
    if(task==""){
       alert("Enter task to do...");
    }
    else{
        document.getElementById("task-list").innerHTML+=`<li class="list" onclick="complete()">${task}<span><button id="del" onclick="Delete()">Delete</button></span></li>`
    }
    document.getElementById("taskinput").value="";
    saveData();
}
function Delete(){
    let elem=event.target.parentNode;
    elem.parentNode.style.display="none";
    saveData();
}
function complete(){
    if(completed){
        event.target.style.textDecoration="none";
    }
    else{
    event.target.style.textDecoration="2px solid line-through";
    }
     completed=completed==false?true:false;
}
function saveData(){
    localStorage.setItem("data",document.getElementById("task-list").innerHTML);
}
function showList(){
    let data=localStorage.getItem("data");
    document.getElementById("task-list").innerHTML=data;
}
showList();