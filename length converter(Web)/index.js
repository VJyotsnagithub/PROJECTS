function cal(){
input_value=document.getElementById("input").value;
to_options=document.getElementById("input_options").value;
from_options=document.getElementById("output_options").value;
var result;
console.log(input_options,output_options)
if(to_options=="kilometer"){
    if(from_options=="meter"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value*100000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 100000</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value*(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+6</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*(1e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+9</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*(1e+12);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+12</p>';
    }
    else if(from_options=="mile"){
        result=input_value/1.609;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold >divide the length by 1.609</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
}
else if(to_options=="meter"){
    if(from_options=="meter"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value*100;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 100</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+6</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*(1e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+9</p>';
    }
    else if(from_options=="mile"){
        result=input_value/1609;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold > divide the length by 1609</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
}
else if(to_options=="centimeter"){
    if(from_options=="meter"){
        result=input_value*100;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 100</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value*10;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 10</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*10000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 10000</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*(1e+7);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+7</p>';
    }
    else if(from_options=="mile"){
        result=input_value/160900;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold > divide the length by 160900</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value*1000000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000000</p>';
    }
}
else if(to_options=="millimeter"){
    if(from_options=="meter"){
        result=input_value/1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1000</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value/10;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 10</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+6</p>';
    }
    else if(from_options=="mile"){
        result=input_value/(1.609e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold >divide the length by 1.609e+6</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value/(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1e+6</p>';
    }
}
else if(to_options=="micrometer"){
    if(from_options=="meter"){
        result=input_value/(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1e+6</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value/10000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 10000</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value/1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1000</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
    else if(from_options=="mile"){
        result=input_value/(1609e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold >divide the length by 1609e+9</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value/(1e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1e+9</p>';
    }
}
else if(to_options=="nanometer"){
    if(from_options=="meter"){
        result=input_value*(1e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiple the length by 1e+9</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value*(1e+7);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiple the length by 1e+7</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value*(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+6</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
    else if(from_options=="mile"){
        result=input_value/(1609e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold >divide the length by 1609e+9</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value*(1e+12);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiple the length by 1e+12</p>';
    }
}
else if(to_options=="nanometer"){
    if(from_options=="meter"){
        result=input_value*(1e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiple the length by 1e+9</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value*(1e+7);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiple the length by 1e+7</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value*(1e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1e+6</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value*1000;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1000</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiply the length by 1</p>';
    }
    else if(from_options=="mile"){
        result=input_value/(1609e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold >divide the length by 1609e+9</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value*(1e+12);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> multiple the length by 1e+12</p>';
    }
}
else if(to_options=="mile"){
    if(from_options=="meter"){
        result=input_value/(160900);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1609</p>';
    }
    else if(from_options=="centimeter"){
        result=input_value/(160900);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 160900</p>';
    }
    else if(from_options=="millimeter"){
        result=input_value/(1.609e+6);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1.609e+6</p>';
    }
    else if(from_options=="micrometer"){
        result=input_value/(1.609e+9);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1.609e+9</p>';
    }
    else if(from_options=="nanometer"){
        result=input_value/(1.609e+12);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1.609e+12</p>';
    }
    else if(from_options=="mile"){
        result=input_value*1;
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold >multiple the length by 1</p>';
    }
    else if(from_options=="kilometer"){
        result=input_value/(1.609);
        document.getElementById("output").value=result;
        document.getElementById("formula").innerHTML='<p><bold>Formula</bold> divide the length by 1.609</p>';
    }
}
}
function reset(){
    document.getElementById("input_options").value="";
    document.getElementById("output_options").value="";
    document.getElementById("input").value="";
    document.getElementById("output").value="";
    
}