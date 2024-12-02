Для проверки валидности данных можно использовать CURL.

BASE_URL="https://api.vk.com/method/users.get"
USER_ID="user_ids"
ACCESS_TOKEN="access_token"
API_VERSION="5.131"

Формируем URL
FULL_URL="${BASE_URL}?user_ids=${USER_ID}&access_token=${ACCESS_TOKEN}&v=${API_VERSION}"

Выполняем запрос
curl -X GET "$FULL_URL"

После этого если вы получили ответ, который выглядит следующим образом:
{
    "response": [
        {
            "id": 249099466,
            "first_name": "Nairi",
            "last_name": "Mnatsakanyan",
            "can_access_closed": true,
            "is_closed": false
        }
    ]
}
то данные валидированы.