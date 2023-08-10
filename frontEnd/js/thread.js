const getList = async () => {
    const response = await fetch('http://localhost:8080/post/list', {method: 'GET'})
        .then((res) => res.json())
        .catch((err) => {
            alert(`一覧取得に失敗しました。エラー：${err}`);
        })

    if (response.code === "200") {
        const list = response.list;


    }
}

const sendPost = async () => {
    const author = document.getElementById('author_name').value
    const message = document.getElementById('post_message').value
    const pass = document.getElementById('password').value

    const requestBody = {
        authorName: author,
        postMessage: message,
        password: pass
    }

    const response = await fetch('http://localhost:8080/post/insert', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
        .then(res => res.json())
        .then(json => {
            alert(`投稿に成功しました, response: ${json}`)
        })
        .catch(err => {
            alert(`投稿に失敗しました, response: ${err}`)
        })
}