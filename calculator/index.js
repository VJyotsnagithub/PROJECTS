let display=document.getElementById("display").value;
function onadd(){
    display+=event.target.value;
    document.getElementById("display").value=display;
}
function oncal(){
    display=eval(display);
    document.getElementById("display").value=display;
   
}
function onclear(){
    display="";
    document.getElementById("display").value=display;

}
function ondel(){
   display=String((display)).slice(0,-1);
    document.getElementById("display").value=display;
}