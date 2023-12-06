import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
private baseUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  public post(url: string, payload: any){
    return this.http.post(`${this.baseUrl}${url}`, payload);
  }
}
