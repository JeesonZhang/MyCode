from flask import Flask
from DBconnection import POOL


app = Flask(__name__)


@app.route("ip")
def get_ip():
    # 获取一个连接对象
    db_conn =

    return 0


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8095)
