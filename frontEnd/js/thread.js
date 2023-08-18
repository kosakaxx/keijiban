const getList = async () => {
  await fetch('http://localhost:8080/post/list', {method: 'GET', headers: {'Content-Type': 'application/json'}})
    .then((res) => res.json())
    .then(json => {
      const {postList, postCount} = json

      const wrapper = document.getElementById('postsWrapper')

      postList.forEach(obj => {
        const box = document.createElement('div')
        box.classList.add('post_box')

        const header = document.createElement('div')
        header.classList.add('post_header')

        const idName = document.createElement('div')
        idName.classList.add('post_id_name_wrapper')

        const postId = document.createElement('p')
        postId.classList.add('post_id')
        postId.innerText = obj.postId

        const postName = document.createElement('p')
        postName.classList.add('post_name')
        postName.innerText = obj.authorName

        const datetimeArea = document.createElement('div')
        datetimeArea.classList.add('post_datetime_area')

        const createdDatetime = document.createElement('p')
        const updatedDatetime = document.createElement('p')

        createdDatetime.innerText = obj.createdDatetime
        updatedDatetime.innerText = obj.updatedDatetime

        const postBody = document.createElement('div')
        postBody.classList.add('post_body')
        postBody.innerText = obj.postMessage

        const postActions = document.createElement('div')
        postActions.classList.add('post_actions')

        const passInput = document.createElement('input')
        passInput.setAttribute('type', 'text')
        passInput.id = `passInput_${obj.postId}`

        const editButton = document.createElement('button')
        editButton.setAttribute('type', 'button')
        editButton.innerText = '編集'
        editButton.onclick = async () => {
        }

        const deleteButton = document.createElement('button')
        deleteButton.setAttribute('type', 'button')
        deleteButton.innerText = '削除'
        deleteButton.onclick = async () => {
          const requestBody = {
            postId: obj.postId,
            password: document.getElementById(`passInput_${obj.postId}`).value
          }

          await fetch('http://localhost:8080/post/delete', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
          })
            .then((res) => res.json())
            .then((json) => {
              location.reload()
              alert(json.message)
            })
            .catch((err) => {
              alert(`投稿に失敗しました。エラー：${err.message}`);
            })
        }

        idName.appendChild(postId)
        idName.appendChild(postName)
        datetimeArea.appendChild(createdDatetime)
        datetimeArea.appendChild(updatedDatetime)
        header.appendChild(idName)
        header.appendChild(datetimeArea)

        postActions.appendChild(passInput)
        postActions.appendChild(deleteButton)

        box.appendChild(header)
        box.appendChild(postBody)
        box.appendChild(postActions)

        wrapper.appendChild(box)
      })
    })
    .catch((err) => {
      alert(`一覧取得に失敗しました。エラー：${err}`);
    })
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

  await fetch('http://localhost:8080/post/insert', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(requestBody)
  })
    .then((res) => res.json())
    .then((json) => {
      location.reload()
      alert(json.message)
    })
    .catch((err) => {
      alert(`投稿に失敗しました。エラー：${err.message}`);
    })
}

const updatePost = async () => {
  const id = document.getElementById('edit_post_id').value
  const author = document.getElementById('edit_author_name').value
  const message = document.getElementById('edit_post_message').value
  const pass = document.getElementById('edit_password').value

  const requestBody = {
    postId: id,
    authorName: author,
    postMessage: message,
    password: pass
  }

  await fetch('http://localhost:8080/post/update', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(requestBody)
  })
    .then((res) => res.json())
    .then((json) => {
      location.reload()
      alert(json.message)
    })
    .catch((err) => {
      alert(`更新に失敗しました。エラー：${err.message}`);
    })
}