import { TestBed } from '@angular/core/testing';

import { CartaJugadorService } from './carta-jugador.service';

describe('CartaJugadorService', () => {
  let service: CartaJugadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartaJugadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
