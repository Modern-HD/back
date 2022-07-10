async function getCommentListFromServer(bno) {
    try {
        const resp = await fetch('/cmt/list/' + bno);
        const cmtList = await resp.json();
        return await cmtList;
    } catch (error) {
        console.log(error);
    }
}

async function updateCommentToServer(cnoVal, cmtText) {
    try {
        const url = '/cmt/modify';
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify({cno:cnoVal, content:cmtText})
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function removeCommentFromServier(cnoVal) {
    try {
        const url = '/cmt/delete';
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify({cno:cnoVal})
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        
    }
}

function spreadCommentList(result) {
    const div = document.getElementById('accordionExample');
    div.innerHTML = "";
    for (let i = 0; i < result.length; i++) {
        let html = `<div class="accordion-item">`;
        html += `<h2 class="accordion-header" id="heading${i}">`;
        html += `<button class="accordion-button" type="button"
        data-bs-toggle="collapse" data-bs-target="#collapse${i}"
        aria-expanded="true" aria-controls="collapse${i}">`;
        html += `CNO: ${result[i].cno} `;
        html += `BNO: ${result[i].bno} `;
        html += `Writer: ${result[i].writer} `;
        html += `</button></h2>`;
        html += `<div id="collapse${i}" class="accordion-collapse collapse show"`;
        html += `aria-labelledby="heading${i}" data-bs-parent="#accordionExample">`;
        html += `<div class="accordion-body">`;
        html += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-warning cmtModBtn">%</button>`;
        html += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-danger cmtDelBtn">X</button>`;
        html += `<input type="text" class="form-control" id="cmtText" value="${result[i].content}">${result[i].content}`;
        html += `${result[i].mod_at}`;
        html += `</div></div></div>`;
        div.innerHTML += html;
    }
}

document.addEventListener('click', (e) => {
    if(e.target.classList.contains('cmtModBtn')) {
        let cnoVal = e.target.dataset.cno;
        let div = e.target.closest('div');
        let cmtText = div.querySelector('#cmtText').value;
        updateCommentToServer(cnoVal, cmtText).then(result => {
            if(result > 0) {
                alert('댓글 수정 성공!');
                document.getElementById('cmtText').value = "";
                printCommentList(bnoVal);
            }
        });
    }
    if(e.target.classList.contains('cmtDelBtn')) {
        // 필요한 cnoVal 변수 얻기
        let cnoVal = e.target.dataset.cno;
        removeCommentFromServier(cnoVal).then(result => {
            if(result > 0) {
                alert('댓글 삭제 성공!');
                document.getElementById('cmtText').value = "";
                printCommentList(bnoVal);
            }
        });
    }
})

function printCommentList(bno) {
    getCommentListFromServer(bno).then(result => {
        console.log(result);
        if(result.length > 0) {
            spreadCommentList(result);
        } else {
            const div = document.getElementById('accordionExample');
            div.innerHTML = "더 이상의 Comment가 존재하지 않습니다.";
        }
    });
}

async function postCommentToServer(cmtData) {
    try {
        const url = "/cmt/post";
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('cmtAddBtn').addEventListener('click', () => {
    const cmtText = document.getElementById('cmtText').value;
    if (cmtText == null || cmtText == '') {
        alert('댓글 내용을 입력해 주세요!');
        return false;
    } else {
        let cmtData = {
            bno: bnoVal,
            writer: document.getElementById('cmtWriter').innerText,
            content: cmtText
        };
        postCommentToServer(cmtData).then(result => {
            if (result > 0) {
                alert('댓글 등록 성공!');
                document.getElementById('cmtText').value = "";
            }
            printCommentList(cmtData.bno);
        });
    }
});