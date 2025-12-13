const { RouteDef } = require('zoinx/core');
const path = require('path');

module.exports = class SongData extends RouteDef {

    constructor(app) {
        let routes = {
            SongData: {
                base: '/songData',
                router: path.join(__dirname, './route'),
                enabled: true
            }
        };
        super(app, routes);
    }

};
