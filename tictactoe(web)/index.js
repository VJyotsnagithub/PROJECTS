let Playerturn="X";
let array=["","","","","","","","",""];
function boxClicked(){
 let box_id=event.target.id;
  if(array[box_id]==""){
    array[box_id]=Playerturn;
  document.getElementById(box_id).innerHTML=Playerturn;
}
   winnerPlayer();
   changePlayerturn();}
function changePlayerturn(){
   Playerturn= Playerturn==="X"?"O":"X";
}
function restart(){
    for(let i=0;i<9;i++){
        array[i]="";
        document.getElementById(i).innerHTML="";
    }
    Playerturn="X";
    document.getElementById("playerText").innerHTML="Tic Tac Toe Game";
}
function winnerPlayer(){
    if((array[0]!="" && array[1]!="" && array[2]!="")&&(array[0]==array[1] && array[1]==array[2])){
      let won=`${Playerturn} Won the Game`;
      document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
    }
    else if((array[3]!="" && array[4]!="" && array[5]!="")&&(array[3]==array[4] && array[4]==array[5])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if((array[6]!="" && array[7]!="" && array[8]!="")&&(array[6]==array[7] && array[7]==array[8])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if((array[0]!="" && array[3]!="" && array[6]!="")&&(array[0]==array[3] && array[3]==array[6])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if((array[1]!="" && array[4]!="" && array[7]!="")&&(array[1]==array[4] && array[4]==array[7])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if((array[2]!="" && array[5]!="" && array[8]!="")&&(array[2]==array[5] && array[5]==array[8])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if((array[0]!="" && array[4]!="" && array[8]!="")&&(array[0]==array[4] && array[4]==array[8])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if((array[2]!="" && array[4]!="" && array[6]!="")&&(array[2]==array[4] && array[4]==array[6])){
        document.getElementById("playerText") .innerHTML=`${Playerturn} Won the Game`;
      }
      else if(array[0]!="" && array[1]!="" && array[2]!="" && array[3]!="" && array[4]!="" && array[5]!="" && array[6]!="" && array[7]!="" && array[8]!=""){
        document.getElementById("playerText").innerHTML="Game is Draw";
      }
}