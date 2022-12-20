<?php
class Prodi_model extends CI_Model {
  public function get_data(){
    $data_mahasiswa = [
      ["prodi"=>"MIF","keterangan"=>"Manajemen Informatika"],
      ["prodi"=>"TKK","keterangan"=>"Teknik Komputer"],
      ["prodi"=>"TIF","keterangan"=>"Teknik Informatika"]];
      return $data_mahasiswa;
  }
}
?>
