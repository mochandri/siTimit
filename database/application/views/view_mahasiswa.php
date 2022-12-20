<div>
    <style>
    .table th{
      background: black;
      color: #fff;
    }
    .table, th, td {
      padding: 8px 20px;
    }
    .table tr:hover {
      background-color: #f5f5f5;
    }
    .table tr:nth-child(even) {
      background-color: #f2f2f2;
    }
    </style>
<table class="table">
<tr>
    <th>No.</th>
    <th>Nama</th>
    <th>Program Studi</th>
</tr>
<?php
$no=1;
foreach($Mahasiswa as $row): ?>
<tr>
    <td><?= $no++ ?></td>
    <td><?= $row['nama']?></td>
    <td><?= $row['prodi']?></td>
</tr>
<?php endforeach?>
</table>
</div>
