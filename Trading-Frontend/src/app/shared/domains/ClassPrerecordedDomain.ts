import { SafeResourceUrl } from "@angular/platform-browser";

export interface ClassPrerecordedDomain{
    id: number;
    title: string;
    description: string;
    urlVideo:  SafeResourceUrl;
    classPrerecordedLevel: number;
}