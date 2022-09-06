import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  /* getUsers(){
    this.http.get('https://reqres.in/api/users?page=2').subscribe(data => {
      console.log(data);
    }); */


    constructor(private http: HttpClient) {}
    getUsuarios():any{
      return  this.http.get('https://retocartassenasoft.azurewebsites.net/Senasoft/Usuario/listar')
    }
    postUsuario(data:Usuario):any{
      return this.http.post('https://retocartassenasoft.azurewebsites.net/Senasoft/Usuario/agregar',data)
    }
  }

  interface Usuario{
    idusuario: number,
    nombre: string,
    partida: {
        idpartida:number,

    },
    tipoUsuario: string,
    resultado: string
}
