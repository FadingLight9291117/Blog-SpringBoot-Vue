export default class Blog {
    constructor(data) {
        this.id = data.id;
        this.title = data.title;
        this.subject = data.subject;
        this.date = data.date;
        this.classify = data.classify;
        this.content = data.content;
        this.author = data.account;
    }
}

export class Admin {
    constructor(data) {
        this.name = data.nickname;
        this.sex = data.sex;
        this.age = data.age;
        this.phone = data.phone;
        this.qq = data.qq;
        this.text = data.text;
    }
}

export class Comment {
    constructor(data) {
        this.name = data.name;
        this.date = data.date;
        this.content = data.content;
    }
}
