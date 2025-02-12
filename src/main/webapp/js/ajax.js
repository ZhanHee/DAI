document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("search-input");
    const searchResults = document.getElementById("search-results");

    searchInput.addEventListener("input", function () {
        const query = searchInput.value.trim();
        if (query.length < 2) { // 只在输入至少 2 个字符后执行查询
            searchResults.style.display = "none";
            return;
        }

        // 使用 AJAX 向后端请求数据
        fetch(`/ProduitController?action=searchProduit&keyword=${query}`)
            .then(response => response.json())
            .then(data => {
                searchResults.innerHTML = "";
                if (data.length === 0) {
                    searchResults.style.display = "none";
                    return;
                }

                // 显示匹配的 produits
                data.forEach(produit => {
                    const li = document.createElement("li");
                    li.classList.add("list-group-item");
                    li.textContent = produit.nom; // 只显示产品名称
                    li.addEventListener("click", function () {
                        searchInput.value = produit.nom; // 选中填充搜索框
                        searchResults.style.display = "none";
                    });
                    searchResults.appendChild(li);
                });

                searchResults.style.display = "block";
            })
            .catch(error => console.error("Erreur de recherche :", error));
    });

    // 点击搜索框外部隐藏搜索建议
    document.addEventListener("click", function (event) {
        if (!searchInput.contains(event.target) && !searchResults.contains(event.target)) {
            searchResults.style.display = "none";
        }
    });
});