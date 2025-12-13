const { Service } = require('zoinx/core');
const { TestHarness } = require('zoinx/testing');
const path = require("path");

module.exports = TestHarness(class UserInfoService extends Service {

    constructor() {
        const domainPath = path.join(__dirname, './domain');
        super(domainPath);
    }

});
