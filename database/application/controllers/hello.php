<?php
  class Hello extends CI_Controller{
    // public function index(){
    //   //echo "<h2>Hello World CI!</h2>";
    //
    //   //memanggil file View
    //   $this->load->view('helloview');//file view
    // }

    public function index(){
      //c3-memuat model 'Hello_model'
      $this->load->model('Hello_model');

      //Pengambilan objek dari kelas Hello_model dan dimuat di var $model
      $model = $this->Hello_model;

      //Mengambil data dari $model
      $a = $model->txt;

      //Membuat data yang akan dikirim ke $view
      $data['teks'] = $a;

      //Memanggil file View
      $this->load->view('helloview', $data);//file view

    }

  }
 ?>
