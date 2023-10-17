import { SafeResourceUrl } from "@angular/platform-browser";

export interface ClassDomain{
    id: number;
    title: string;
    description: string;
    classLevel: number;
    urlVideo:  SafeResourceUrl;
}