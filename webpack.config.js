//Утилита для работы с переменными окружения разных ОС
const path = require('path');
//Плагин для разделения модулей
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
    //Режим разработки, заменить перед деплоем
    mode: 'development',
    devtool: 'source-map',
    //Сборка проекта будет начинатьсяс указанных файлов
    entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js', 'main.js'),
    devServer: {
        contentBase: './dist',
        compress: true,
        port: 8000,
        allowedHosts: [
            'localhost:9000'
        ]
    },
    module: {
        rules: [
            {//Пропускаем через babel все *.js файлы
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {//Пропускаем через vue-loader все *.vue файлы
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    resolve: {
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}