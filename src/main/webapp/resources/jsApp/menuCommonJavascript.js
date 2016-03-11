function le_parece(formObj) { 
    if(!confirm("Esta seguro que quiere desloguearse?")) { 
           if(!confirm(" Esta seguro ?  \n Esta es su última oportunidad .\n \n Se abrirá otra ventana \n para evitarle molestias.")) 
           {
        	   return false;
        	   } 
              else {
               	open("ejemplos/jscript/pregunta.htm");
               return false;
             }   
      }
}


