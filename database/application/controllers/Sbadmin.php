<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Sbadmin extends CI_Controller{
  function __construct(){
    parent::__construct();
    $this->load->model('Mahasiswa_model');
  }

  public function index(){
    $data['Mahasiswa']=$this->Mahasiswa_model->get_data();
    $this->template->views('view_mahasiswa',$data);
  }
}
?>
