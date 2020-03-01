export class PrepaidCard{

    constructor(public cardProgramDescription : string, 
                public maskedPan:string, 
                public panGuid:string,
                public suspended:boolean,
                public cardStatusId:number,
                public stopped:boolean)
    {

    }
}