export interface UserDomain {
    id: number;
    name: string;
    email: string;
    password: string;
    userLevel: number;
    status: boolean;
    userRole: String; 
    backtesting: string;
    auditedAccount: string;
}