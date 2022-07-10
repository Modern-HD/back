async function getRepliesListFromServer(pno) {
    try {
        const resp = await fetch("/rps/list/" + pno);
        const rpsList = await resp.json();
        return await rpsList;
    } catch (error) {
        console.log(error);
    }
}

async function postRepliseToServer(rps) {
    try {
        const url = "/rps/post";
        const config = {
            method: 'post',
            header: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rps)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function updateRepliseToServer(rps) {
    try {
        const url = "/rps/modify";
        const config = {
            method: 'post',
            header: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rps)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}

async function deleteRepliseToServer(rnoVal) {
    try {
        const url = "/rps/delete";
        const config = {
            method: 'post',
            header: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify({rno: rnoVal})
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}

document.getElementById('rpsAddBtn').addEventListener('click', () => {
    const rpsText = document.getElementById("rpsText").value;
    if(rpsText == null || rpsText == "") {
        alert("댓글 내용을 입력해주세요")
    } else {
        const rps = {
            pno: pnoVal,
            replier: document.getElementById('rspReplier').innerText,
            reply: rpsText
        }
        postRepliseToServer(rps).then(result => {
            console.log(result);
            if(result > 0) {
                alert("댓글 등록 성공!");
                printRepliesList(pnoVal);
            } else {
                alert("댓글 등록 실패");
            }
        });
    }
})

document.addEventListener('click', (e) => {
    if (e.target.classList.contains('rpsModBtn')) {
        const rnoVal = e.target.dataset.rno;
        const rps = {
            rno: rnoVal,
            reply: document.querySelector(`#rpsText${rnoVal}`).value
        }
        updateRepliseToServer(rps).then(result => {
            if(result > 0) {
                alert("댓글 수정 성공");
                printRepliesList(pnoVal);
            } else {
                alert("댓글 수정 실패");
            }
        })
    } else if(e.target.classList.contains('rpsDelBtn')) {
        const rnoVal = e.target.dataset.rno;
        deleteRepliseToServer(rnoVal).then(result => {
            if(result > 0) {
                alert("댓글 삭제 성공");
                printRepliesList(pnoVal);
            } else {
                alert("댓글 삭제 실패");
            }
        })
    }
})

function spreadRepliesList(result) {
    const div = document.getElementById('accordionExample');
    div.innerHTML = "";
    for (let i = 0; i < result.length; i++) {
        let html = `<div class="accordion-item">`;
        html += `<h2 class="accordion-header" id="heading${i}">`;
        html += `<button class="accordion-button" type="button"
        data-bs-toggle="collapse" data-bs-target="#collapse${i}"
        aria-expanded="true" aria-controls="collapse${i}">`;
        html += `RNO: ${result[i].rno} `;
        html += `PNO: ${result[i].pno} `;
        html += `Replier: ${result[i].replier} `;
        html += `</button></h2>`;
        html += `<div id="collapse${i}" class="accordion-collapse collapse show"`;
        html += `aria-labelledby="heading${i}" data-bs-parent="#accordionExample">`;
        html += `<div class="accordion-body">`;
        html += `<button type="button" data-rno="${result[i].rno}" class="btn btn-sm btn-outline-warning rpsModBtn">%</button>`;
        html += `<button type="button" data-rno="${result[i].rno}" class="btn btn-sm btn-outline-danger rpsDelBtn">X</button>`;
        html += `<input type="text" class="form-control" id="rpsText${result[i].rno}" value="${result[i].reply}">${result[i].reply}`;
        html += `${result[i].mod_at}`;
        html += `</div></div></div>`;
        div.innerHTML += html;
    }
}

function printRepliesList(pno) {
    getRepliesListFromServer(pno).then(result => {
        console.log(result);
        if(result.length > 0) {
            spreadRepliesList(result);
        } else {
            const div = document.getElementById('accordionExample');
            div.innerHTML = "더 이상의 Replies가 존재하지 않습니다.";
        }
    });
}