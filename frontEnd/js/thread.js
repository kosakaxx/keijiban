const getList = async() => {
  const response = await fetch('http://localhost:8080/post/list', {method: 'GET'})
    .then((res) => res.json())
    .catch((err) => {
      alert(`一覧取得に失敗しました。エラー：${err}`);
    })

  if (response.code === "200") {
    const list = response.list;


  }
}