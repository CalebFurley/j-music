const { RouteDef } = require('zoinx/core');
const path = require('path');

module.exports = class UserInfo extends RouteDef {

    constructor(app) {
        let routes = {
            UserInfo: {
                base: '/userInfo',
                router: path.join(__dirname, './route'),
                enabled: true
            }
        };
        super(app, routes);
    }

};
