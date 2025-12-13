'use strict'

const { Domain } = require('zoinx/core');
const mongoose = global.mongoosePool;
const { randomUUID } = require('crypto');

const schema = mongoose.Schema(
    {
        "username":String,
        "email":String,
        "password":String,
        "age":String,
        "address":{
            "street":String,
            "city":String,
            "state":String,
            "zip":String
        },
    },
    {
    timestamps: {
        createdAt: 'create_timestamp',
        updatedAt: 'updated_timestamp'
     }
});

module.exports = class UserInfoDomain extends Domain {

    constructor() {
        super(mongoose.model('UserInfo', schema, 'data.userInfo'));
    }

    list() {
        return this.getDomain().find().sort('name').select('-__v');
    }

}
