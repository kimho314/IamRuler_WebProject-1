window.addEventListener("load", function(){
    var section = document.querySelector("#infor");
    var bodyShape = section.querySelector("#bodyshape");

    bodyShape.onchange = function(){
       
        var img = section.querySelector(".object-stage img");
        var value = bodyShape.value;
        
        if(value == "nomal") img.src = "images/main_simulator1.png";
        else if(value == "smallInverseTriangle") img.src = "images/main_simulator2.png";
        else if(value == "triangle") img.src = "images/main_simulator3.png";
        else if(value == "inverseTriangle") img.src = "images/main_simulator4.png";
        else if(value == "square") img.src = "images/main_simulator5.png";
        
    };

    var gender = document.getElementsByName("gender");
    for(var i=0;i<gender.length;i++){
        gender[i].onclick = function(){
            //alert(this.value);
            switch(this.value){
                case "woman":
                    var genderCheck = document.querySelector("#clothcheck");
                    genderCheck.querySelector("#genderW").style.display="flex";
                    genderCheck.querySelector("#genderM").style.display="none";
                    break;
                case "man":
                    var genderCheck = document.querySelector("#clothcheck");
                    genderCheck.querySelector("#genderM").style.display="flex";
                    genderCheck.querySelector("#genderW").style.display="none";
                    break;
            };
        };
    };
    
});

window.addEventListener("load", function(){
    var section = document.querySelector("#clothcheck");
    var clothCheck = section.getElementsByClassName("clothcheck-box");
    for(var i=0;i<clothCheck.length;i++){
        //console.log(clothCheck[i]);
        clothCheck[i].onclick = function(){
            switch(this.id){
                case "checkTop":
                    //alert("checkTop");
                    var detailcheck = document.querySelector("#detailsize");
                    detailcheck.querySelector("#top").style.display="flex";
                    detailcheck.querySelector("#pants").style.display="none";
                    detailcheck.querySelector("#outer").style.display="none";
                    detailcheck.querySelector("#skirt").style.display="none";
                    detailcheck.querySelector("#onepiece").style.display="none";
                    break;
                case "checkOuter":
                    //alert("checkOuter");
                    var detailcheck = document.querySelector("#detailsize");
                    detailcheck.querySelector("#top").style.display="none";
                    detailcheck.querySelector("#pants").style.display="none";
                    detailcheck.querySelector("#outer").style.display="flex";
                    detailcheck.querySelector("#skirt").style.display="none";
                    detailcheck.querySelector("#onepiece").style.display="none";
                    break;
                case "checkPants":
                    //alert("checkPants");
                    var detailcheck = document.querySelector("#detailsize");
                    detailcheck.querySelector("#top").style.display="none";
                    detailcheck.querySelector("#pants").style.display="flex";
                    detailcheck.querySelector("#outer").style.display="none";
                    detailcheck.querySelector("#skirt").style.display="none";
                    detailcheck.querySelector("#onepiece").style.display="none";
                    break;
                case "checkSkirt":
                    //alert("checkSkirt");
                    var detailcheck = document.querySelector("#detailsize");
                    detailcheck.querySelector("#top").style.display="none";
                    detailcheck.querySelector("#pants").style.display="none";
                    detailcheck.querySelector("#outer").style.display="none";
                    detailcheck.querySelector("#skirt").style.display="flex";
                    detailcheck.querySelector("#onepiece").style.display="none";
                    break;
                case "checkOnepiece":
                    //alert("checkOnepiece");
                    var detailcheck = document.querySelector("#detailsize");
                    detailcheck.querySelector("#top").style.display="none";
                    detailcheck.querySelector("#pants").style.display="none";
                    detailcheck.querySelector("#outer").style.display="none";
                    detailcheck.querySelector("#skirt").style.display="none";
                    detailcheck.querySelector("#onepiece").style.display="flex";
                    break;
            };
        };
    };
});

// 팝업 결과창 -미완성
// window.addEventListener("load", function(){
//     var div = document.querySelector("#popup");
//     var popUp = div.querySelector(".contents");
//     for(var i=0;i<popUp.length;i++){
//         popUp[i].onclick = function(){
//             switch(this.id){
//                 case "con-small":
//                     break;
//                 case "con-middle":
//                     break;
//                 case "con-big":
//                     break;
//             };
//         };
//     };
// });
