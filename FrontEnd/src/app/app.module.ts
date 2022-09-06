import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioService } from 'src/services/usuario.service';
import { AppComponent } from './app.component';
import { InicioComponent } from './inicio/inicio.component';
import { PartidaComponent } from './partida/partida.component';

/* import { OtroComponenteComponent } from './otro-componente/otro-componente.component'; */
const routes:Routes=[
  {
    path:"",
    component:AppComponent
  },
  {
    path:"inicio",
    component:InicioComponent
  },
  {
    path:"partida",
    component:PartidaComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    PartidaComponent,

    /* OtroComponenteComponent */
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
