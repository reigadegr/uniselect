#@REM npm install -force && npm install axios -force && npm install element-plus -force && npm run serve
[ ! -d $(dirname "$0")/node_modules ] && (yarn install || pkg install yarn && yarn install)
yarn serve
