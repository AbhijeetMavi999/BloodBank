export class BloodDonation {
    constructor(
        public state: string = "",
        public area: string = "",
        public pinCode: number = 0,
        public bloodGroup: string = "",
        public city: string = "",
        public hospitalName: string = ""
    ) {}
}