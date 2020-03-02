import { Injectable } from '@angular/core';
import { ConfigurationService } from "./configuration.service";
import { Http, Response, Headers, RequestOptions, Jsonp } from "@angular/http";
import { Observable } from "rxjs/Rx";
import 'rxjs/add/operator/catch';

declare function unescape(s: string): string;
declare function escape(s: string): string;

@Injectable()
export class APIService {

    constructor(private _ConfigurationService: ConfigurationService, 
                private _http: Http) {
    }

    postCommand(plainPayload, path): Observable<any> {
        var postData = {
            Payload: plainPayload.toString()
        };

        var requestHeaders = this.generateHeaders();

        let headers = new Headers(requestHeaders.headers); // ... Set content type to JSON
        let options = new RequestOptions({ headers: headers }); // Create a request option

        console.log('URL : ' + this._ConfigurationService.geturls().baseUrl + path);

        return this._http.post(this._ConfigurationService.geturls().baseUrl + path, plainPayload, options)
            .map((response: Response) => {
                return response.json();
            })
            .catch(this.handleError);        
    }
    
    getCommand(path): Observable<any> {                             
        console.log('URL : ' + this._ConfigurationService.geturls().actuatorUrl + path);

        return this._http.get(this._ConfigurationService.geturls().actuatorUrl + path)
            .map((response: Response) => {
                return response.json();
            })
            .catch(this.handleError);        
    }

    generateHeaders() {
        var requestHeaders = {
            headers: {
                'content-type': 'application/json',
                'Accept': '*/*',
                'client-id': 'e5c08502-e4b9-4f3e-a2c3-eab9680bbbe7',     
            }
        }
        return requestHeaders;
    }

    private handleError(error: Response) {        
        console.log(error);
        return Observable.throw(error);
    }    


    checkHealth(){
        return this.getCommand('info');
    }

    listPhonebooks(userId){

        var request = { userId : userId };

        var plainPayload = JSON.stringify(request);       

        return this.postCommand(plainPayload, 'list-phonebooks');
    }

    addPhonebook(userId, description){

        var request = { userId : userId, description : description };

        var plainPayload = JSON.stringify(request);       

        console.log(plainPayload);

        return this.postCommand(plainPayload, 'enlist');
    }

    listPhonebookEntries(userId, phonebookId){

        var request = { userId : userId, phonebookId : phonebookId };

        var plainPayload = JSON.stringify(request);       

        return this.postCommand(plainPayload, 'list-entries');
    }

    addPhonebookEntry(phonebookId, description, phoneNumber){

        var request = { phonebookId : phonebookId, description : description, phoneNumber : phoneNumber };

        var plainPayload = JSON.stringify(request);       

        console.log(plainPayload);

        return this.postCommand(plainPayload, 'enlist-entry');
    }
    
}