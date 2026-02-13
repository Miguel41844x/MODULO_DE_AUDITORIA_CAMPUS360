let events = [];

fetch('audit-events.json')
.then(res => res.json())
.then(data => {
events = data;
renderTable(events);
});

function renderTable(data){
const tbody = document.getElementById("tableBody");
tbody.innerHTML="";
data.forEach(e=>{
tbody.innerHTML+=`
<tr>
<td>${e.timestamp}</td>
<td>${e.user}</td>
<td>${e.action}</td>
<td>${e.entity}</td>
<td><button onclick="showDetail(${e.id})">Ver</button></td>
</tr>`;
});
}

function showDetail(id){
const event = events.find(e=>e.id===id);
document.getElementById("modalContent").textContent=
JSON.stringify(event,null,2);
document.getElementById("modal").classList.remove("hidden");
}

function closeModal(){
document.getElementById("modal").classList.add("hidden");
}

function applyFilters(){
const user = document.getElementById("userFilter").value;
const action = document.getElementById("actionFilter").value;

let filtered = events.filter(e=>
(user===""||e.user.includes(user)) &&
(action===""||e.action===action)
);

renderTable(filtered);
}

function exportData(){
const blob = new Blob([JSON.stringify(events,null,2)],{type:"application/json"});
const a = document.createElement("a");
a.href=URL.createObjectURL(blob);
a.download="audit-export.json";
a.click();
}
