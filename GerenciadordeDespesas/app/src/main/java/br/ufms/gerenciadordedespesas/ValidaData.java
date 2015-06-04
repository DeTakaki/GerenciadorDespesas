package escobar.gabriel.engsoftware;

/**
 * Created by Gabriel on 02/06/2015.
 */
public class ValidaData {

    /* retorna se a data e valida ou nao [1-31][1-12][1980-2300], bisexto, padrao DD/MM/YYYY  */
    public boolean isValid(String msg){
        String[] a = msg.split("/");
        if(a.length != 3)
            return false;
        for(String i : a){
            if(i.matches(""))
                return false;
        }

        int ano = Integer.parseInt(a[2]);
        int mes = Integer.parseInt(a[1]);
        int dia = Integer.parseInt(a[0]);
        if(ano > 1995 && ano < 2300 ){
            boolean bi = (ano %400 == 0) || (ano %4 ==0 && ano%100 != 0);

            if(mes > 0 && mes < 13){

                if(dia > 0 && dia < 32){
                    if(mes ==2){
                        if(bi){
                            if(dia > 29){
                                return false;
                            }
                            else{
                                return true;
                            }
                        }
                        else{
                            if( dia > 28)
                                return false;
                            return true;
                        }
                    }
                    else{
                        if(mes > 0 && mes < 8){
                            if(mes %2 == 0){
                                if(dia == 31)
                                    return false;
                                return true;
                            }
                        }
                        if(mes > 7 && mes < 13){
                            if(mes % 2 != 0){
                                if(dia == 31)
                                    return false;
                                return true;
                            }
                        }
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

        }
        else{
            return false;
        }

        return true;
    }

    /* retorna a data no padrao DD/MM/YYYY , so pode ser chamando se a data for valida*/
    public String getDateValid(String msg){
        String[] a = msg.split("/");

        int dia = Integer.parseInt(a[0]);
        int mes = Integer.parseInt(a[1]);
        int ano = Integer.parseInt(a[2]);
        String dias;
        if(dia < 10)
            dias = "0"+dia;
        else
            dias =""+dia;

        String mess;

        if(mes < 10)
            mess = "0"+mes;
        else
            mess =""+mes;

        return (dias+"/"+mess+"/"+ano);
    }


}
