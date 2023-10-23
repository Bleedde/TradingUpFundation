export interface UserDomain {
    id: number;
    name: string;
    email: string;
    password: string;
    userLevel: number;
    status: boolean;
    backtesting: string;
    auditedAccount: string;
    userRole: string;
}