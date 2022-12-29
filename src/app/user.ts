export class User {
    constructor(
        public userId: number = 0,
        public firstName: string = "",
        public lastName: string = "",
        public age: number = 0,
        public gender: string = "",
        public contactNumber: number = 0,
        public email: string = "",
        public password: string = "",
        public weight: number = 0,
        public state: string = "",
        public area: string = "",
        public pinCode: number = 0,
        public bloodGroup: string = ""
    ) {}
}