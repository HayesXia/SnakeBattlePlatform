const GOOD_GAME_OBJECTS = [];

export class GoodGameObject {
    constructor() {
        GOOD_GAME_OBJECTS.push(this);
        this.timedelta = 0;
        this.has_called_start = false;
    }

    start() {      //只执行一次

    }

    update() {      //除了第一帧，每一帧都执行一次

    }

    on_destroy() {    //删除前执行

    }

    destroy() {
        for (let i in GOOD_GAME_OBJECTS) {
            const obj = GOOD_GAME_OBJECTS[i];
            if (obj === this) {
                GOOD_GAME_OBJECTS.splice(i);
                break;
            }
        }
    }
}

let last_timestamp;     //上一次执行的时刻

const step = timestamp => {
    for (let obj of GOOD_GAME_OBJECTS){
        if (!obj.has_called_start) {
            obj.has_called_start = true;
            obj.start();
        } else {
            obj.timedelta = timestamp - last_timestamp;
            obj.update();
        }
    }

    last_timestamp = timestamp;
    requestAnimationFrame(step)
}

requestAnimationFrame(step)