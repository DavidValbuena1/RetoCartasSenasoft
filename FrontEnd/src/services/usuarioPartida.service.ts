import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class JugadorPartidaService {

  constructor(private http: HttpClient) {}
  getJugadorPartidas(id:number):any{
    return  this.http.get('https://retocartassenasoft.azurewebsites.net/Senasoft/JugadorPartida/listar/' + id)
  }


  postJugadorPartida(data:JugadorPartida):any{
    return this.http.post<JugadorPartida>('https://retocartassenasoft.azurewebsites.net/Senasoft/JugadorPartida/agregar',data).subscribe((x:any)=>console.log(x))
  }
}
interface JugadorPartida {
/*   idJugadorPartida: number, */
  codigo: string,
  estado: number,
  rondas: number,
  resultado: string
}
