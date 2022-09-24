if (document.getElementById('product_del_btn') != null) {
    document.getElementById('product_del_btn').addEventListener('click', () => {
        const del_form = document.getElementById('del_form');
        const pno_val = document.getElementById('pno').innerText;
        document.getElementById('input_pno').value = pno_val;
        del_form.setAttribute("action", "/product/delete");
        del_form.submit();
    });
}

document.addEventListener('click', (e) => {
    console.log(e.target.id);
    if (e.target.classList.contains('th-img')) {
        const img_src = e.target.getAttribute('src').replace("_th_", "_");
        console.log(img_src);
        document.getElementById('row_img').setAttribute("src",img_src);
        document.getElementById('img_modal').classList.remove('d-none');
    } else if (e.target.id != 'row_img') {
        document.getElementById('img_modal').classList.add('d-none');
    }
});