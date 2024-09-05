let AddEmployeeSection =document.getElementById("AddEmployeeSection");
let addempcard = document.getElementById("addempcard");
let viewempcard = document.getElementById("viewempcard");
let viewallempcard = document.getElementById("viewallempcard");
let viewenterID =document.getElementById("viewenterID");
let dataviewempsection=document.getElementById("dataviewempsection");
let submitbtnviewenterID=document.getElementById("submitbtnviewenterID");
console.log("jsss");


addempcard.addEventListener("click",()=>{
    addempcard.style.transform="translateY(-50px) scale(1.2)";
    addempcard.style.transition="2s all";
    AddEmployeeSection.style.display="flex";


 viewenterID.style.display="none";
 viewempcard.style.transform="translateY(0px) scale(1)";
 viewallempcard.style.transform="translateY(0px) scale(1)";

    
});

viewempcard.addEventListener("click",()=>{
    viewempcard.style.transform="translateY(-50px) scale(1.2)";
    viewempcard.style.transition="2s all";
    viewenterID.style.display="flex";


    AddEmployeeSection.style.display="none";
    addempcard.style.transform="translateY(0px) scale(1)";
    viewallempcard.style.transform="translateY(0px) scale(1)";
    
});

viewallempcard.addEventListener("click",()=>{
    viewallempcard.style.transform="translateY(-50px) scale(1.2)";
    viewallempcard.style.transition="2s all";

    AddEmployeeSection.style.display="none";
    viewenterID.style.display="none";
    viewempcard.style.transform="translateY(0px) scale(1)";
    addempcard.style.transform="translateY(0px) scale(1)";
 
    
});


// Buttons listner

submitbtnviewenterID.addEventListener("click",()=>{
    dataviewempsection.style.display="flex";

// none displays 
viewenterID.style.display="none";
});